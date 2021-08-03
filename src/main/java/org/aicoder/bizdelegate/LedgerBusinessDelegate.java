package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.LedgerDAO;
import org.archcorner.chartreuse.pojo.Ledger;

public class LedgerBusinessDelegate{ 


private LedgerDAO ledgerDAO ;

public int getHighestId()
 {
  ledgerDAO = new LedgerDAO();
   int id=ledgerDAO.getHighestId();
   return id;
 } 

public void insertLedger(Ledger ledger)
 {
  ledgerDAO = new LedgerDAO();
  ledgerDAO.insertLedger(ledger);
 } 

public void updateLedger(Ledger ledger)
 {
  ledgerDAO = new LedgerDAO();
  ledgerDAO.updateLedger(ledger);
 } 

public void deleteLedger(Ledger ledger)
 {
  ledgerDAO = new LedgerDAO();
  ledgerDAO.deleteLedger(ledger);
 } 

public Ledger  getLedgerById(int ledgerId)
 {
  ledgerDAO = new LedgerDAO();
  Ledger ledger= ledgerDAO.getLedgerById(ledgerId);
 return ledger;
 } 

public Ledger  getLedger(String ledgerName)
 {
  ledgerDAO = new LedgerDAO();
  Ledger ledger= ledgerDAO.getLedger(ledgerName);
 return ledger;
 } 

public List<Ledger>  getAll( )
 {
  ledgerDAO = new LedgerDAO();
   List<Ledger>  ledgers = ledgerDAO.getLedgers( );
 return ledgers;
 } 

} 

