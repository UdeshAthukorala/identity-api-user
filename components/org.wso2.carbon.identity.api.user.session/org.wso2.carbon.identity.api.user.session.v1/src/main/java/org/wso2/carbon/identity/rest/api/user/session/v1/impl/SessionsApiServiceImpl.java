/*
 * Copyright (c) 2022, WSO2 LLC. (http://www.wso2.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.rest.api.user.session.v1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.wso2.carbon.identity.api.user.common.ContextLoader;
import org.wso2.carbon.identity.rest.api.user.session.v1.SessionsApiService;
import org.wso2.carbon.identity.rest.api.user.session.v1.core.SessionManagementService;
import org.wso2.carbon.identity.rest.api.user.session.v1.dto.SearchResponseDTO;

import javax.ws.rs.core.Response;

/**
 * Implementation of SessionsApi Service.
 */
public class SessionsApiServiceImpl extends SessionsApiService {

    @Autowired
    private SessionManagementService sessionManagementService;

    @Override
    public Response getSessions(String filter, Integer limit, Long since, Long until) {

        SearchResponseDTO responseDTO = sessionManagementService.getSessions(ContextLoader.getTenantDomainFromContext(),
                filter, limit, since, until);

        return Response.ok().entity(responseDTO).build();
    }
}
