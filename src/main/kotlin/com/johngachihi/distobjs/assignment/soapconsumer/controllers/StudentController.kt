package com.johngachihi.distobjs.assignment.soapconsumer.controllers

import com.johngachihi.distobjs.assignment.soapconsumer.consumingwebservice.wsdl.Student
import com.johngachihi.distobjs.assignment.soapconsumer.soapclients.StudentSoapClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class StudentController {

    @Autowired
    lateinit var studentSoapClient: StudentSoapClient

    @GetMapping("/student/{admissionNumber}")
    @ResponseBody
    fun getStudent(
        @PathVariable admissionNumber: Int
    ): Student = studentSoapClient.getStudent(admissionNumber).student

    @GetMapping("/student-lookup")
    fun studentLookup(): String = "student-lookup"


    @PostMapping("/student")
    @ResponseBody
    fun registerStudent(@RequestBody student: Student): Int =
        studentSoapClient.registerStudent(student).studentAdmissionNumber

    @GetMapping("/student-registration")
    fun registration(): String = "student-registration"
}