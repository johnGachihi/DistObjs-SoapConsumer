package com.johngachihi.distobjs.assignment.soapconsumer.soapclients

import com.johngachihi.distobjs.assignment.soapconsumer.consumingwebservice.wsdl.*
import org.springframework.ws.client.core.support.WebServiceGatewaySupport
import org.springframework.ws.soap.client.core.SoapActionCallback

class StudentSoapClient: WebServiceGatewaySupport() {

    fun getStudent(admissionNumber: Int): GetStudentResponse {
        val request = GetStudentRequest()
        request.admissionNumber = admissionNumber

        return webServiceTemplate.marshalSendAndReceive(
            "http://localhost:8080/ws/",
            request,
            SoapActionCallback(
                "http://johngachihi.com/dist-objs/soap/GetStudentRequest"
            )
        ) as GetStudentResponse
    }

    fun registerStudent(student: Student): RegisterStudentResponse {
        val request = RegisterStudentRequest()
        request.student = student

        return webServiceTemplate.marshalSendAndReceive(
            "http://localhost:8080/ws/",
            request,
            SoapActionCallback(
                "http://johngachihi.com/dist-objs/soap/RegisterStudentRequest"
            )
        ) as RegisterStudentResponse
    }
}