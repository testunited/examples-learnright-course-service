package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
  name 'get by booktitle id 1'
  request {
    method 'GET'
    url '/booktitles/1/courses'
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
	 }
]
	""")
 }
}