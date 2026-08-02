<?php 


class Customer
 { 

   private  $_customerId ;

   public function  getCustomerId( ) 
     {
      return $this->_customerId;

     }

   public function  setCustomerId(  $customerId ) 
     {
      $this->_customerId = $customerId;

     }

   private  $_name ;

   public function  getName( ) 
     {
      return $this->_name;

     }

   public function  setName(  $name ) 
     {
      $this->_name = $name;

     }

   private  $_streetAddress ;

   public function  getStreetAddress( ) 
     {
      return $this->_streetAddress;

     }

   public function  setStreetAddress(  $streetAddress ) 
     {
      $this->_streetAddress = $streetAddress;

     }

   private  $_state ;

   public function  getState( ) 
     {
      return $this->_state;

     }

   public function  setState(  $state ) 
     {
      $this->_state = $state;

     }

   private  $_country ;

   public function  getCountry( ) 
     {
      return $this->_country;

     }

   public function  setCountry(  $country ) 
     {
      $this->_country = $country;

     }

   private  $_zipcode ;

   public function  getZipcode( ) 
     {
      return $this->_zipcode;

     }

   public function  setZipcode(  $zipcode ) 
     {
      $this->_zipcode = $zipcode;

     }

   private  $_contactNo ;

   public function  getContactNo( ) 
     {
      return $this->_contactNo;

     }

   public function  setContactNo(  $contactNo ) 
     {
      $this->_contactNo = $contactNo;

     }

   private  $_city ;

   public function  getCity( ) 
     {
      return $this->_city;

     }

   public function  setCity(  $city ) 
     {
      $this->_city = $city;

     }

 }
?>
