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

package com.github.cookbit.model.datasource;

import com.github.cookbit.entity.DatasourceConfig;
import lombok.Data;
import lombok.ToString;

/**
 * 数据源修改请求
 *
 * @auther 961374431@qq.com
 * @date 2022年03月06日
 */
@Data
@ToString(callSuper = true)
public class DatasourceModifyRequest extends DatasourceConfig {
}
