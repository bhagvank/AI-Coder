package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.BeneficiaryDAO;
import org.archcorner.chartreuse.pojo.Beneficiary;

public class BeneficiaryBusinessDelegate{ 


private BeneficiaryDAO beneficiaryDAO ;

public int getHighestId()
 {
  beneficiaryDAO = new BeneficiaryDAO();
   int id=beneficiaryDAO.getHighestId();
   return id;
 } 

public void insertBeneficiary(Beneficiary beneficiary)
 {
  beneficiaryDAO = new BeneficiaryDAO();
  beneficiaryDAO.insertBeneficiary(beneficiary);
 } 

public void updateBeneficiary(Beneficiary beneficiary)
 {
  beneficiaryDAO = new BeneficiaryDAO();
  beneficiaryDAO.updateBeneficiary(beneficiary);
 } 

public void deleteBeneficiary(Beneficiary beneficiary)
 {
  beneficiaryDAO = new BeneficiaryDAO();
  beneficiaryDAO.deleteBeneficiary(beneficiary);
 } 

public Beneficiary  getBeneficiaryById(int beneficiaryId)
 {
  beneficiaryDAO = new BeneficiaryDAO();
  Beneficiary beneficiary= beneficiaryDAO.getBeneficiaryById(beneficiaryId);
 return beneficiary;
 } 

public Beneficiary  getBeneficiary(String beneficiaryName)
 {
  beneficiaryDAO = new BeneficiaryDAO();
  Beneficiary beneficiary= beneficiaryDAO.getBeneficiary(beneficiaryName);
 return beneficiary;
 } 

public List<Beneficiary>  getAll( )
 {
  beneficiaryDAO = new BeneficiaryDAO();
   List<Beneficiary>  beneficiarys = beneficiaryDAO.getBeneficiarys( );
 return beneficiarys;
 } 

} 

