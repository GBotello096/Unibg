

import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.classifiers.bayes.NaiveBayesUpdateable;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Vector;

import java.io.File;
public class Weka {
    public static String prediction;
    public void Call() throws Exception {

        //carica il Dataset
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File("Dataset.arff"));
        Instances structure = loader.getStructure();//istances indica che si tratta di un oggetto di tipo Instances
        structure.setClassIndex(structure.numAttributes() - 1);

        // Costruisce il Classificatore
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(structure);
        Instance current; //istance rappresenta che si sta parlando di un attributo
        //current è l'istanza della struttura che sto caricando e finché è != 0 
        //questa istanza viene caricata nel classificatore nb
        while ((current = loader.getNextInstance(structure)) != null)
            nb.updateClassifier(current);

        //carica il dato per classificare 
        DataSource test = new DataSource("Test.arff"); //carica il datset di test 
        Instances teststructure = test.getDataSet(); //crea un'istanza che è il dataset di test che viene letto 
        teststructure.setClassIndex(teststructure.numAttributes()-1); //

        //prendi la classe degli attributi 
        double label = nb.classifyInstance(teststructure.instance(0));// per classificare la figura
        teststructure.instance(0).setClassValue(label); //

        //fa la predizione 
        Instance newInst= teststructure.instance(teststructure.numInstances()-1);
        double predNB=nb.classifyInstance(newInst); //avvia l'algoritmo sull'istanza 
        System.out.println("The AI said that the figure is: "+structure.classAttribute().value((int) predNB)); //
        prediction=structure.classAttribute().value((int) predNB); //

         // Evaluation //
        Evaluation evaluation = new Evaluation(structure);
        evaluation.evaluateModel(nb,teststructure);
        System.out.println(evaluation.toSummaryString("\nResults",false));

    }
}
