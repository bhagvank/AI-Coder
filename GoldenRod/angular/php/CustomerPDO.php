<?php 
require_once("DataObject.php");
require_once("Customer.php");


class CustomerPDO extends DataObject
 { 


  public function getMaxId()
  {
   $connection = parent::connect();
   $maxIdSql = "SELECT MAX(CUSTOMERID) AS MAXCUSTOMERID FROM CUSTOMER";
   $rows = $connection->query($maxIdSql);
   $maxid=0;
   if(count($rows) > 0)
    {
      foreach($rows as $row)
      {
        $maxid = $row[0];
      }
    }
    parent::disconnect($connection);
    return $maxid;
  }

  public function  insertCustomer( $customer)
   {
     $connection = parent::connect();
     $insertSQL = "INSERT INTO CUSTOMER(CUSTOMERID,CUSTOMERNAME,STREETADDRESS,STATE,COUNTRY,ZIPCODE,CONTACTNO,CITY) VALUES(:customerid,:name,:streetaddress,:state,:country,:zipcode,:contactno,:city)";
      try
      {
       $statement = $connection->prepare($insertSQL);
        $statement->bindValue(":customerid",$this->getMaxId()+1,PDO::PARAM_INT);
       $statement->bindValue(":name",$customer->getName(),PDO::PARAM_STR);
       $statement->bindValue(":city",$customer->getCity(),PDO::PARAM_STR);
       $statement->bindValue(":state",$customer->getState(),PDO::PARAM_STR);
       $statement->bindValue(":zipcode",$customer->getZipCode(),PDO::PARAM_STR);
       $statement->bindValue(":contactno",$customer->getContactNo(),PDO::PARAM_STR);
       $statement->bindValue(":streetaddress",$customer->getStreetAddress(),PDO::PARAM_STR);
       $statement->bindValue(":country",$customer->getCountry(),PDO::PARAM_STR);
       $statement->execute();
       parent::disconnect($connection);
      }
      catch(PDOException $exception)
        {
         echo "exception Message" . $exception->getMessage();
         parent::disconnect($connection);
         print_r($connection->errorInfo());
        }
 }

  public function  updateCustomer( $customer)
   {
     $connection = parent::connect();
     $updateSQL = "UPDATE CUSTOMER SET CUSTOMERNAME=:name,STREETADDRESS=:streetaddress,STATE=:state,COUNTRY=:country,ZIPCODE=:zipcode,CONTACTNO=:contactno,CITY=:city WHERE CUSTOMERID=:customerid";
      try
      {
       $statement = $connection->prepare($updateSQL);
        $statement->bindValue(":customerid",$customer->getCustomerId(),PDO::PARAM_INT);
       $statement->bindValue(":name",$customer->getName(),PDO::PARAM_STR);
       $statement->bindValue(":city",$customer->getCity(),PDO::PARAM_STR);
       $statement->bindValue(":state",$customer->getState(),PDO::PARAM_STR);
       $statement->bindValue(":zipcode",$customer->getZipCode(),PDO::PARAM_STR);
       $statement->bindValue(":contactno",$customer->getContactNo(),PDO::PARAM_STR);
       $statement->bindValue(":streetaddress",$customer->getStreetAddress(),PDO::PARAM_STR);
       $statement->bindValue(":country",$customer->getCountry(),PDO::PARAM_STR);
       $statement->execute();
       parent::disconnect($connection);
      }
      catch(PDOException $exception)
        {
         echo "exception Message" . $exception->getMessage();
         parent::disconnect($connection);
         print_r($connection->errorInfo());
        }
 }

public function deleteCustomer($customer)
 {
  $connection = parent::connect();
  $deletesql = "DELETE FROM CUSTOMER WHERE CUSTOMERID =:customerid";
  try
   {
     $statement = $connection->prepare($deletesql);
     $statement->bindValue(":customerid",$customer->getCustomerId(),PDO::PARAM_INT);
     $statement->execute();
     parent::disconnect($connection);
   }
   catch(PDOException $exception)
    {
        echo "exception Message" . $exception->getMessage();
        parent::disconnect($connection);
        print_r($connection->errorInfo());
    }
 }

public function getCustomer($customerid)
 {
	$connection = parent::connect();
   $selectSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERID=:customerid";
	$customer = "";
	 try
	  {
	    $statement = $connection->prepare($selectSQL);
       $statement->bindValue(":customerid",$customerid,PDO::PARAM_INT);
       $statement->execute();
	    $row = $statement->fetch();
       $customer = new Customer();
       $customer->setCustomerid($row[0]);
       $customer->setName($row[1]);
       $customer->setCity($row[2]);
       $customer->setState($row[3]);
       $customer->setZipCode($row[4]);
       $customer->setContactNo($row[5]);
       $customer->setStreetAddress($row[6]);
       $customer->setCountry($row[7]);
      parent::disconnect($connection);
	 }
	catch(PDOException $exception)
    {
        echo "exception Message" . $exception->getMessage();
        parent::disconnect($connection);
       print_r($connection->errorInfo());
    }
     return $customer;
 }

public function checkCustomerExists($customer)
{
     $connection = parent::connect();
     $selectSQL = "SELECT * FROM CUSTOMER WHERE CUSTOMERNAME=:customername";
	 $customer = "";
	 try
	 {
	  $statement = $connection->prepare($selectSQL);
     $statement->bindValue(":name",$customer->getCustomerName(),PDO::PARAM_INT);
     $statement->execute();
	 $row = $statement->fetch();
       $customer = new Customer();
       $customer->setCustomerid($row[0]);
       $customer->setName($row[1]);
       $customer->setCity($row[2]);
       $customer->setState($row[3]);
       $customer->setZipCode($row[4]);
       $customer->setContactNo($row[5]);
       $customer->setStreetAddress($row[6]);
       $customer->setCountry($row[7]);
      parent::disconnect($connection);
	 }
	catch(PDOException $exception)
    {
        echo "exception Message" . $exception->getMessage();
        parent::disconnect($connection);
       print_r($connection->errorInfo());
    }
     return $customer;
 }

public function getCustomers()
 {
   $connection = parent::connect();
     $selectSQL = "SELECT * FROM CUSTOMER";
     $rows = $connection->query($selectSQL);
     $customers = array();
     foreach($rows as $row)
      {
       $customer = new Customer();
       $customer->setCustomerid($row[0]);
       $customer->setName($row[1]);
       $customer->setCity($row[2]);
       $customer->setState($row[3]);
       $customer->setZipCode($row[4]);
       $customer->setContactNo($row[5]);
       $customer->setStreetAddress($row[6]);
       $customer->setCountry($row[7]);
       $customers[] = $customer;
   }
     parent::disconnect($connection);
     return $customers;
 }

public function getRow($customerid)
 {
   $connection = parent::connect();
     $selectSQL = "SELECT * FROM CUSTOMERWHERE CustomerID=".intval($customerid);
     $rows = $connection->query($selectSQL);
     $customers = array();
     foreach($rows as $row)
      {
       $customer = new Customer();
       $customer->setCustomerid($row[0]);
       $customer->setName($row[1]);
       $customer->setCity($row[2]);
       $customer->setState($row[3]);
       $customer->setZipCode($row[4]);
       $customer->setContactNo($row[5]);
       $customer->setStreetAddress($row[6]);
       $customer->setCountry($row[7]);
       $customers[] = $customer;
   }
     parent::disconnect($connection);
     return $customers;
 }

public function getRows()
 {
   $connection = parent::connect();
     $selectSQL = "SELECT * FROM CUSTOMER";
     $rows = $connection->query($selectSQL);
     $customers = array();
$i=0;
     foreach($rows as $row)
      {
       $customers[$i]["customerid"] = $row[0];
       $customers[$i]["customername"] = $row[1];
       $customers[$i]["city"] = $row[2];
       $customers[$i]["state"] = $row[3];
       $customers[$i]["zipcode"] = $row[4];
       $customers[$i]["contactno"] = $row[5];
       $customers[$i]["streetaddress"] = $row[6];
       $customers[$i]["country"] = $row[7];
$i++;
   }
     parent::disconnect($connection);
     return $customers;
 }

 }
?>
