package com.learn.rest.service.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import com.learn.rest.service.exception.ForbiddenException;
import com.learn.rest.service.exception.MissingAuthorizationException;
import com.learn.rest.service.exception.UnAuthorizedException;


@Provider

public class SecurityFilter implements ContainerRequestFilter{

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		if( method.isAnnotationPresent(DenyAll.class) || method.isAnnotationPresent(RolesAllowed.class)){


			if( method.isAnnotationPresent(DenyAll.class)){
				throw new ForbiddenException();
			}

			final String token = requestContext.getHeaderString(AUTHORIZATION_PROPERTY);
			if(null == token){
				throw new MissingAuthorizationException();
			}
				
			
		
				String credential = token.replaceFirst(AUTHENTICATION_SCHEME+" ", "");
				String userCredential = new String(Base64.getDecoder().decode(credential));
				//Split username and password tokens
				final StringTokenizer tokenizer = new StringTokenizer(userCredential, ":");
				final String username = tokenizer.nextToken();
				final String password = tokenizer.nextToken();//Verifying Username and password
				System.out.println(username);
				System.out.println(password);

				//Verify user access
				if(method.isAnnotationPresent(RolesAllowed.class))
				{
					RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
					Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

					//Is user valid?
							if( ! isUserAllowed(username, password, rolesSet))
							{
								throw new UnAuthorizedException();
							}
				}
		}
	}
    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet)
    {
        boolean isAllowed = false;
          
        //Step 1. Fetch password from database and match with password in argument
        //If both match then get the defined role for user from database and continue; else return isAllowed [false]
        //Access the database and do this part yourself
        //String userRole = userMgr.getUserRole(username);
         
        if(username.equals("kundan") && password.equals("kumar"))
        {
            String userRole = "ADMIN";
             
            //Step 2. Verify user role
            if(rolesSet.contains(userRole))
            {
                isAllowed = true;
            }
        }
        return isAllowed;
    }
}