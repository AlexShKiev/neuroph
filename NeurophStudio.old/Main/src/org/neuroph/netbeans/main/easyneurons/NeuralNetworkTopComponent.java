package org.neuroph.netbeans.main.easyneurons;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JPanel;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.events.NeuralNetworkEvent;
import org.neuroph.core.events.NeuralNetworkEventListener;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.netbeans.main.ViewManager;
import org.neuroph.netbeans.main.easyneurons.dialog.BackpropagationTrainingDialog;
import org.neuroph.netbeans.main.easyneurons.dialog.HebbianTrainingDialog;
import org.neuroph.netbeans.main.easyneurons.dialog.SetNetworkInputDialog;
import org.neuroph.netbeans.main.easyneurons.dialog.SupervisedTrainingDialog;
import org.neuroph.netbeans.main.easyneurons.view.JNeuralNetwork;
import org.neuroph.nnet.learning.DynamicBackPropagation;
import org.neuroph.util.NeuralNetworkType;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.LookupListener;
import org.openide.util.NbBundle;
import org.openide.util.lookup.Lookups;
import org.openide.windows.CloneableTopComponent;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays neural network.
 */
public final class NeuralNetworkTopComponent extends CloneableTopComponent implements LookupListener, NeuralNetworkEventListener {

    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "NeuralNetworkTopComponent";
    boolean userPaused;
    



    public NeuralNetworkTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(NeuralNetworkTopComponent.class, "CTL_NeuralNetworkTopComponent"));
        setToolTipText(NbBundle.getMessage(NeuralNetworkTopComponent.class, "HINT_NeuralNetworkTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
    }

    public NeuralNetworkTopComponent(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
        this.easyNeuronsViewController = ViewManager.getInstance();
        this.trainingController = new NeuralNetworkTraining(this.neuralNetwork);
        // neuralNetwork.addObserver(this);
        
        associateLookup (Lookups.singleton (neuralNetwork));

        initComponents();

        blockView.setNetwork(neuralNetwork);
        this.scrollPanel.getViewport().add(blockView); // ako je ovaj pre initComponents() baca exception

        // init the other stuff from Nb
        this.setName(neuralNetwork.getLabel());
//                setName(NbBundle.getMessage(NeuralNetworkTopComponent.class, "CTL_NeuralNetworkTopComponent"));
        setToolTipText(NbBundle.getMessage(NeuralNetworkTopComponent.class, "HINT_NeuralNetworkTopComponent"));
        //        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        trainButton = new javax.swing.JButton();
        setInputButton = new javax.swing.JButton();
        calculateButton = new javax.swing.JButton();
        randomizeButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        viewComboBox = new javax.swing.JComboBox();
        testButton = new javax.swing.JButton();
        trainingSetField = new javax.swing.JTextField();
        weightsHistogram = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();

        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.jLabel1.text")); // NOI18N
        buttonPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 70, -1));

        trainButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(trainButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.trainButton.text")); // NOI18N
        trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(trainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        setInputButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(setInputButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.setInputButton.text")); // NOI18N
        setInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setInputButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(setInputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 80, -1));

        calculateButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(calculateButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.calculateButton.text")); // NOI18N
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(calculateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        randomizeButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(randomizeButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.randomizeButton.text")); // NOI18N
        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(randomizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        resetButton.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(resetButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        viewComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Block View", "Graph View", "Design View" }));
        viewComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                viewComboBoxItemStateChanged(evt);
            }
        });
        buttonPanel.add(viewComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, -1, -1));

        org.openide.awt.Mnemonics.setLocalizedText(testButton, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.testButton.text")); // NOI18N
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(testButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, 20));

        trainingSetField.setEditable(false);
        trainingSetField.setText(org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.trainingSetField.text")); // NOI18N
        buttonPanel.add(trainingSetField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 130, -1));

        org.openide.awt.Mnemonics.setLocalizedText(weightsHistogram, org.openide.util.NbBundle.getMessage(NeuralNetworkTopComponent.class, "NeuralNetworkTopComponent.weightsHistogram.text")); // NOI18N
        weightsHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightsHistogramActionPerformed(evt);
            }
        });
        buttonPanel.add(weightsHistogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 81, 20));

        scrollPanel.setPreferredSize(new java.awt.Dimension(700, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainButtonActionPerformed
        train();
    }//GEN-LAST:event_trainButtonActionPerformed

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateButtonActionPerformed
        trainingController.calculate();
    }//GEN-LAST:event_calculateButtonActionPerformed

    private void randomizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeButtonActionPerformed
        trainingController.randomize();
    }//GEN-LAST:event_randomizeButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        trainingController.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void setInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setInputButtonActionPerformed
        SetNetworkInputDialog dialog = new SetNetworkInputDialog(null, true,
                this.trainingController);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_setInputButtonActionPerformed

    private void viewComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_viewComboBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String viewMode = viewComboBox.getSelectedItem().toString();

            if (viewMode.equals("Block View")) {
                switchToView(BLOCK_VIEW);
            } else if (viewMode.equals("Graph View")) {
                switchToView(GRAPH_VIEW);
            } else if (viewMode.equals("Design View")) {
                ViewManager.getInstance().openVisualEditorWindow(neuralNetwork);                
            }
        }

    }//GEN-LAST:event_viewComboBoxItemStateChanged

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
       TestTopComponent.getDefault().open();       
       TestTopComponent.getDefault().requestActive();
        TestTopComponent.getDefault().clear();

       double totalMSE = 0;
       
       Iterator<DataSetRow> iterator = trainingSet.iterator();
       while(iterator.hasNext()) {
          DataSetRow trainingEl = iterator.next();
          double[] inputs = trainingEl.getInput();
          neuralNetwork.setInput(inputs);
          neuralNetwork.calculate();
          double[] outputs = neuralNetwork.getOutput();

          double desiredOutputs[] = trainingEl.getDesiredOutput();
          double errors[] = new double[outputs.length];
          double patternError = 0;
          for(int i = 0; i< outputs.length; i++) {
              errors[i] = outputs[i] - desiredOutputs[i];
              patternError += errors[i]*errors[i];
          }    
            patternError = patternError / errors.length;
          
          String outputStr = "Input: " + arrayToString(inputs) + " Output: " + arrayToString(outputs) + "Desired output: " + arrayToString(desiredOutputs) + " Error: " + arrayToString(errors) + "\r\n";

          TestTopComponent.getDefault().output(outputStr);
          totalMSE += patternError;
       }

       totalMSE = totalMSE / trainingSet.size();
       
       TestTopComponent.getDefault().output("Total Mean Square Error: " + totalMSE);
       
    }//GEN-LAST:event_testButtonActionPerformed

    private void weightsHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightsHistogramActionPerformed
        //launch the histogram component
        HistogramChartTopComponent.getDefault().open();
        HistogramChartTopComponent.getDefault().requestActive();
        HistogramChartTopComponent.getDefault().populateHistBins(neuralNetwork);
    }//GEN-LAST:event_weightsHistogramActionPerformed
    // + formatiranje na 3 decimale i dugme clear
    private String arrayToString(double[] arr) {
        StringBuilder result = new StringBuilder();
        NumberFormat numberFormat = DecimalFormat.getNumberInstance();
	numberFormat.setMaximumFractionDigits(4);

        for (int i=0; i<arr.length; i++) {
           result.append( numberFormat.format(arr[i]) + "; ");
        }

        return result.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton calculateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton setInputButton;
    private javax.swing.JButton testButton;
    private javax.swing.JButton trainButton;
    private javax.swing.JTextField trainingSetField;
    private javax.swing.JComboBox viewComboBox;
    private javax.swing.JButton weightsHistogram;
    // End of variables declaration//GEN-END:variables

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
    }

    Lookup.Result<DataSet> trainingResultSets;

    @Override
    public void resultChanged(LookupEvent le) {
        Lookup.Result r = (Lookup.Result) le.getSource();
        Collection c = r.allInstances();
        if (!c.isEmpty()) {
            trainingSet = (DataSet) c.iterator().next();
            trainingSetField.setText(trainingSet.toString());
        }
    }

    @Override
    public void componentOpened() {
        TopComponent projWindow = WindowManager.getDefault().findTopComponent("projectTabLogical_tc") ;
        trainingResultSets = projWindow.getLookup().lookupResult(DataSet.class);
        trainingResultSets.addLookupListener(this);
        resultChanged(new LookupEvent(trainingResultSets));
        neuralNetwork.addListener(this);
    }

    @Override
    public void componentClosed() {
        trainingResultSets.removeLookupListener(this);
        ViewManager.getInstance().onNetworkClose(neuralNetwork);
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    private NeuralNetwork neuralNetwork;
    private DataSet trainingSet;
    private JNeuralNetwork blockView = new JNeuralNetwork();
    private NeuralGraphRenderer neuralGraphRenderer;
    private JPanel graphView;
    private NeuralNetworkTraining trainingController;
    private boolean graphViewActive = false;
    private String filePath;
    private static ViewManager easyNeuronsViewController;
    public static final int BLOCK_VIEW = 1;
    public static final int GRAPH_VIEW = 2;

    public void train() {
       // TrainingSet trainingSet = (TrainingSet) trainingSetsComboBox.getSelectedItem();
        trainingController.setTrainingSet(trainingSet);
        userPaused = false;

        NeuralNetworkType nnetType = neuralNetwork.getNetworkType(); // kod tipa
        // mreze

        //checks compitability of neural network and training set - iissue with bias neurons
//        if (trainingController.checkCompatibility(neuralNetwork, trainingSet) == false) {
//            JOptionPane.showMessageDialog(this, "Incompatibility warning: Dimensons of selceted neural network " + neuralNetwork.toString() + " and training set are not the same. You must choose a training set with same dimensions.", "Training", JOptionPane.WARNING_MESSAGE);
//            return;
//        }

        switch (nnetType) {
            case ADALINE:
                showLmsTrainingDialog();
                break;
            case PERCEPTRON:
                showLmsTrainingDialog(); /* perceptronTraining(); */
                break;
            case MULTI_LAYER_PERCEPTRON:
                showMLPTrainingDialog();
                break;
            case RBF_NETWORK:
                showLmsTrainingDialog(); /* showRbfTrainingDialog */
                break;
            case HOPFIELD:
                trainingController.train();
                break;
            case KOHONEN: /* KohonenTrainDlg(); */
                break;
            case NEURO_FUZZY_REASONER:
                showLmsTrainingDialog();
                break;
            case SUPERVISED_HEBBIAN_NET:
                showHebbianTrainingDialog();
                break;

            default:
                trainingController.train();
                break;
        } // switch*/

    }

    private void showLmsTrainingDialog() {
        SupervisedTrainingDialog trainingDialog = new SupervisedTrainingDialog(null, easyNeuronsViewController, true,
                this.trainingController);
        trainingDialog.setLocationRelativeTo(this);
        trainingDialog.setVisible(true);
    }

    private void showMLPTrainingDialog() {
        if (trainingController.getNetwork().getLearningRule() instanceof DynamicBackPropagation) {
            BackpropagationTrainingDialog trainingDialog = new BackpropagationTrainingDialog(null, easyNeuronsViewController, true,
                    this.trainingController);
            trainingDialog.setLocationRelativeTo(this);
            trainingDialog.setVisible(true);
        } else {
            showLmsTrainingDialog();
        }
    }

    private void showHebbianTrainingDialog() {
        HebbianTrainingDialog trainingDialog = new HebbianTrainingDialog(null,
                true, easyNeuronsViewController, this.trainingController);
        trainingDialog.setLocationRelativeTo(this);
        trainingDialog.setVisible(true);
    }

    public NeuralNetworkTraining getController() {
        return this.trainingController;
    }

    public void switchToView(int view) {
        if (view == GRAPH_VIEW) {
            // za rekurzivne modele baca exception
            this.scrollPanel.getViewport().remove(blockView);
            blockView = null;
            try {
                neuralGraphRenderer = new NeuralGraphRenderer(this.neuralNetwork);
                neuralGraphRenderer.createGraphPanel();
                graphView = neuralGraphRenderer.getGraphPanel();
                this.scrollPanel.setViewportView(graphView);
            } catch (Exception ex) {
            }

            graphViewActive = true;

        } else if (view == BLOCK_VIEW) {
            neuralGraphRenderer = null;
            //this.getContentPane().remove(graphView);
            if (graphView!=null) {
                this.remove(graphView);
            }

            blockView = new JNeuralNetwork();
            blockView.setNetwork(neuralNetwork);
            //  this.scrollPanel.getViewport().add(blockView);
            this.scrollPanel.setViewportView(blockView);

            //this.getContentPane().add(scrollPanel);
            this.add(scrollPanel);
            graphViewActive = false;

        }
        //refresh();
        this.scrollPanel.revalidate();
        this.scrollPanel.repaint();

        // also needs this, to fit after resize
        this.revalidate();
        this.repaint();
    }

//    @Override
    public void update() {
        if (graphViewActive) {
            graphView = neuralGraphRenderer.getGraphPanel();
            graphView.revalidate();
            graphView.repaint();
        } else {
            blockView.update();
        }
    }

    public void updateTitle() {
        this.setName(neuralNetwork.toString());
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public NeuralNetwork getNeuralNetwork() {
        return neuralNetwork;
    }

    @Override
    public void handleNeuralNetworkEvent(NeuralNetworkEvent nnet) {
        update();
    }

  
}