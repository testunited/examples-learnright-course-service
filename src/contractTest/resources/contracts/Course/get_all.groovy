package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
  request {
    method 'GET'
    url '/courses'
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
[
	 {
		 "id": 1,
		 "name": "Sams Teach Yourself Java in 21 Days - June 2019 Intake",
		 "status":"ReadyForEnrolment",
		 "bookTitleId": 1
	 },
	 {
		 "id": 2,
		 "name": "Sams Teach Yourself Java in 21 Days - July 2019 Intake",
		 "status":"Provisioned",
		 "bookTitleId": 1
	 },
	 {
		 "id": 3,
		 "name": "Spring in Action, Fifth Edition - Summer Camp 2019",
		 "status":"ReadyForEnrolment",
		 "bookTitleId": 2
	 },
	 {
		 "id": 4,
		 "name": "Spring in Action, Fifth Edition - Fall 2019 Full Course",
		 "status":"Provisioned",
		 "bookTitleId": 2
	 }
]
	""")
 }
}