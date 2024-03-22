/*
 * Copyright (C) 2022 Dremio
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
package org.projectnessie.s3mock.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.annotation.Nullable;
import org.immutables.value.Value;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonSerialize(as = ImmutableS3Object.class)
@JsonDeserialize(as = ImmutableS3Object.class)
@Value.Immutable
public interface S3Object {

  @JsonProperty("Key")
  String key();

  @JsonProperty("LastModified")
  @Nullable
  String lastModified();

  @JsonProperty("ETag")
  @Nullable
  String etag();

  @JsonProperty("Size")
  @Nullable
  String size();

  @JsonProperty("StorageClass")
  @Nullable
  StorageClass storageClass();

  @JsonProperty("Owner")
  @Nullable
  Owner owner();

  static ImmutableS3Object.Builder builder() {
    return ImmutableS3Object.builder();
  }
}
