package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.AttachmentDAO;
import org.archcorner.chartreuse.pojo.Attachment;

public class AttachmentBusinessDelegate{ 


private AttachmentDAO attachmentDAO ;

public int getHighestId()
 {
  attachmentDAO = new AttachmentDAO();
   int id=attachmentDAO.getHighestId();
   return id;
 } 

public void insertAttachment(Attachment attachment)
 {
  attachmentDAO = new AttachmentDAO();
  attachmentDAO.insertAttachment(attachment);
 } 

public void updateAttachment(Attachment attachment)
 {
  attachmentDAO = new AttachmentDAO();
  attachmentDAO.updateAttachment(attachment);
 } 

public void deleteAttachment(Attachment attachment)
 {
  attachmentDAO = new AttachmentDAO();
  attachmentDAO.deleteAttachment(attachment);
 } 

public Attachment  getAttachmentById(int attachmentId)
 {
  attachmentDAO = new AttachmentDAO();
  Attachment attachment= attachmentDAO.getAttachmentById(attachmentId);
 return attachment;
 } 

public Attachment  getAttachment(String attachmentName)
 {
  attachmentDAO = new AttachmentDAO();
  Attachment attachment= attachmentDAO.getAttachment(attachmentName);
 return attachment;
 } 

public List<Attachment>  getAll( )
 {
  attachmentDAO = new AttachmentDAO();
   List<Attachment>  attachments = attachmentDAO.getAttachments( );
 return attachments;
 } 

} 

