package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
	  name 'get by id 1'
	  request {
	    method 'GET'
	    url '/courses/1'

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
{
	 "id": 1,
	 "name": "Sams Teach Yourself Java in 21 Days - June 2019 Intake",
	 "status":"ReadyForEnrolment",
	 "bookTitleId": 1
}
	  		""")
	 }
	}