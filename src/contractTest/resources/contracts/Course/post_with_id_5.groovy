package org.testunited.examples.learnright.course.test.contract

import org.springframework.cloud.contract.spec.Contract
//import org.springframework.http.HttpStatus

Contract.make {
	name 'post with id 5'
	request {
		method 'POST'
		url '/courses'
		headers {
			header('Content-Type', 'application/json')
		}
		body (
			id: $(p(5),c(anyNumber())),
			name: $(p("Mastering Spring Boot 2.0 - Sept 2019 Intake"),c(nonEmpty())),
			bookTitleId: $(p(3),c(anyNumber()))
		)
	}
	response {
		status 201
		headers { 
			header('Content-Type': 'application/json')
		}
		body (
			id: fromRequest().body('$.id'),
			name: fromRequest().body('$.name'),
			bookTitleId : fromRequest().body('$.bookTitleId')
		)		
	}
}