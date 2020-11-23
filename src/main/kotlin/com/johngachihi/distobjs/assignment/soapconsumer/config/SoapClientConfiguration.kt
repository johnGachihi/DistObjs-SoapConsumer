package com.johngachihi.distobjs.assignment.soapconsumer.config

import com.johngachihi.distobjs.assignment.soapconsumer.soapclients.StudentSoapClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
class SoapClientConfiguration {

    @Bean
    fun marshaller(): Jaxb2Marshaller = Jaxb2Marshaller().apply {
        contextPath = "com.johngachihi.distobjs.assignment.soapconsumer.consumingwebservice.wsdl"
    }

    @Bean
    fun studentSoapClient(jaxb2Marshaller: Jaxb2Marshaller): StudentSoapClient =
        StudentSoapClient().apply {
            defaultUri = "http://localhost:8080/ws"
            marshaller = jaxb2Marshaller
            unmarshaller = jaxb2Marshaller
        }
}