package edu.utah.bmi.nlp;

import org.apache.uima.UIMAException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.text.AnnotationFS;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.CasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.CasIOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public class ReadXMI {
    public static void main(String[] args) throws UIMAException, IOException {
        JCas jcas = JCasFactory.createJCas("desc/type/pipeline_v1");
        CAS cas=jcas.getCas();
        CasIOUtils.load(new FileInputStream("data/3_10646_r.txt.xmi"),cas);
        Type type = CasUtil.getType(cas, "edu.utah.bmi.nlp.type.system.IND_PNEUMONIA");
        Collection<AnnotationFS> annotations = CasUtil.select(cas, type);
        for (AnnotationFS anno:annotations){
            System.out.println(anno.getCoveredText()+"("+ anno.getBegin()+"~"+anno.getEnd()+")");
        }
    }
}
