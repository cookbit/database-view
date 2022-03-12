/*
 * Copyright 2021-2022 COOKBIT
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jinzhaosn.common.model.request;

import lombok.Data;

import static java.util.Objects.isNull;

/**
 * 页请求
 *
 * @auther 961374431@qq.com
 * @date 2022年03月12日
 */
@Data
public class PageRequest implements IRequest {
    private Integer pageSize; // 页大小
    private Integer pageNum; // 页码

    /**
     * 主要对页大小进行校验并纠正
     *
     * @return 成功
     */
    @Override
    public boolean validate() {
        if (isNull(pageNum) || pageNum < 0) {
            pageNum = 1;
        }

        if (isNull(pageSize) || pageSize < 0) {
            pageSize = 15;
        }
        return true;
    }
}
