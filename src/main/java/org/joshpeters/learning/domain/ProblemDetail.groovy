package org.joshpeters.learning.domain

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Immutable

@Immutable
class ProblemDetail {
  @JsonProperty(required = true)
  final String type
  @JsonProperty(required = true)
  final String title
  @JsonProperty(required = true)
  final String detail
  @JsonProperty(required = true)
  final String instance
  @JsonProperty(required = false)
  final Map<String,?> otherDetails
}
