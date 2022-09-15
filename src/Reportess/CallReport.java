
package Reportess;


import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public final class CallReport {
    
        
    public void abrirReporte(String ruta_archivo, Connection cn){
        JasperReport reporte = null;
        try{
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource(ruta_archivo));

            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,null, cn);
            
            JasperViewer view = new JasperViewer(jasperPrint,false);
            view.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar abrir el reporte " +ex, "Reportes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}


