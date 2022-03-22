package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
  name 'get by booktitle id 3 no courses'
  request {
    method 'GET'
    url '/booktitles/11/courses'
    headers {
      header('Accept', 'application/json')
    }
  }
response {
  status 200
  headers {
    header('Content-Type': 'application/json')
  }
  body ("""
[]
	""")
 }
}