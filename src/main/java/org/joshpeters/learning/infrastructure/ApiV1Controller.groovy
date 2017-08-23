package org.joshpeters.learning.infrastructure

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('api/v1')
class ApiV1Controller {
  @RequestMapping(path = 'messages', method = RequestMethod.GET)
  List<String> messages() {
    ['this', 'is', 'an', 'api', 'call']
  }

  @RequestMapping(path = 'messages', method = RequestMethod.POST)
  String kaboom() {
    throw new Error("Something bad occurred")
  }

}
