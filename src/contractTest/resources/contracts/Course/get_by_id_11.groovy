package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
	  name 'get by id 11 non existent'
	  request {
	    method 'GET'
	    url '/courses/11'

	    headers {
	      header('Accept', 'application/json')
	    }
	  }
	response {
	  status 404
	}
}