/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.and open the template in the editor.
 */

package utils;

/**
 *
 * @author LWL
 */

//import java.io.InputStream;
//import java.io.OutputStream;
//import gnu.io.CommPortIdentifier; 
//import gnu.io.SerialPort;
//import gnu.io.SerialPortEvent; 
//import gnu.io.SerialPortEventListener; 
//import java.util.Enumeration;
//
//public class RXCommunication implements SerialPortEventListener {
// 
//    SerialPort serialPort;
//    
//    //  muy importante esta parte ya que muchas personas se pierden en este paso y no
//// se realiza la comunicación como queremos podemos borrar las demas opciones dep
////endiendo de cual sistemas operativo tengamos para mi caso solo dejo la de windows y coloco "COM36".
//    private static final String PORT_NAMES[] = {  
//
//        //"/dev/tty.usbserial-A9007UX1", // Mac OS X
//        //"/dev/ttyUSB0", // Linux
//        //"/dev/ttyACM0" // Linux
//        "COM12"//"COM3", // Windows
//   };
//    
//    /** Buffered input stream from the port */
//    private InputStream input;
//    /** The output stream to the port */
//    private OutputStream output;
//    /** Milliseconds to block while waiting for port open */
//    private static final int TIME_OUT = 2000;
//    /** Default bits per second for COM port. */
//    private static final int DATA_RATE = 9600; 
//
////velocidad de transferencia de datos y tiene q coincidir con la que tenemos con //arduino de lo contrario no se establece la comunicación.
//
// public void initialize() {
//
//  CommPortIdentifier portId = null;
//  Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
//
//  // iterate through, looking for the port
//  while (portEnum.hasMoreElements()) {
//   CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
//   for (String portName : PORT_NAMES) {
//    if (currPortId.getName().equals(portName)) {
//     portId = currPortId;
//    System.out.println("PORTCOM: " + currPortId.getName());
//    System.out.println("CURRENT OWNER: " + currPortId.getCurrentOwner());
//     break;
//    }
//   }
//  }
//  
//  System.out.println("PORTID: " + portId);
//
//  if (portId == null) {
//   System.out.println("Could not find COM port.");
//
//// en caso de arrojarnos could no find COM port debemos revisar la direccion del //puerto.
//   return;
//  }
//
//  try {
//   // open serial port, and use class name for the appName.
//   serialPort = (SerialPort) portId.open(this.getClass().getName(),
//     TIME_OUT);
//
//   // set port parameters
//   serialPort.setSerialPortParams(DATA_RATE,
//     SerialPort.DATABITS_8,
//     SerialPort.STOPBITS_1,
//     SerialPort.PARITY_NONE);
//
//   // open the streams
//   input = serialPort.getInputStream();
//   output = serialPort.getOutputStream();
//
//    //add event listeners
//   serialPort.addEventListener(this);
//   serialPort.notifyOnDataAvailable(true);
//   
////   InputStream entrada = puertoSerie.getInputStream();
//// String s="";
//// while (input.available() > 0)
//// {
////  int dato = input.read();
////  s=s+(char)dato;
//// }
////
//  } catch (Exception e) {
//   System.err.println(e.toString());
//  }
// }
//
// /**
//  * This should be called when you stop using the port.
//  * This will prevent port locking on platforms like Linux.
//  */
// public synchronized void close() {
//  if (serialPort != null) {
//   serialPort.removeEventListener();
//   serialPort.close();
//  }
// }
//
// /**
//  * Handle an event on the serial port. Read the data and print it.
//  */
// public synchronized void serialEvent(SerialPortEvent oEvent) {
//  if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
//   try {
//    int available = input.available();
//    byte chunk[] = new byte[available];
//    input.read(chunk, 0, available);
//
//    // Displayed results are codepage dependent
//    System.out.print(new String(chunk));
//   } catch (Exception e) {
//    System.err.println(e.toString());
//   }
//  }
//  // Ignore all the other eventTypes, but you should consider the other ones.
// }
//
// public static void main(String[] args) throws Exception {
//  RXCommunication main = new RXCommunication();
//  main.initialize();
//  System.out.println("Started");
//
////Si todo la anterior esta bien entonces nos debe imprimir que el puerto esta ini//ciado y nos debe imprimir lo que tiene el arduio en el puerto seria osea el Hol//a Mundo
// }
//}





//public class EjemploRXTX {
//    static CommPortIdentifier portId;
//    static CommPortIdentifier saveportId;
//    static Enumeration  portList;
//    static InputStream inputStream;
//    static OutputStream outputStream;
//    static BufferedInputStream bufferedInputStream;
//    static SerialPort  serialPort;
//   
//   
//    public static void main(String[] args){
//        boolean gotPort = false;
//        String port;
//        portList = CommPortIdentifier.getPortIdentifiers();
//       
//        while (portList.hasMoreElements()) {
//            portId = (CommPortIdentifier) portList.nextElement(); //get next port to check
//            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
//                if ( portId.getName().equals("COM4") ) {
//                    port = portId.getName(); 
//                    gotPort = true;
//                }
//               
//                if (gotPort == true) {
//                    try {
//                        serialPort = (SerialPort)portId.open("SMSSender", 2000);
//                    } catch (PortInUseException ex) {
//                        ex.printStackTrace();
//                    }
//                    try {
//                        outputStream = serialPort.getOutputStream();
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    try {
//                        serialPort.setSerialPortParams(19200,
//                                SerialPort.DATABITS_8,
//                                SerialPort.STOPBITS_2,
//                                SerialPort.PARITY_NONE
//                                );
//                    } catch (UnsupportedCommOperationException ex) {
//                        ex.printStackTrace();
//                    }
//                   
//                    try {
//                        inputStream = serialPort.getInputStream();
//                        bufferedInputStream = new BufferedInputStream(inputStream);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                   
//                    serialPort.notifyOnDataAvailable(true);
//                }
//            }
//        }
//       
//       //Escribir en el puerto serie
//       try {
//            if (!(outputStream == null))
//                outputStream.write("array de váis que queremos enviar");
//           
//            byte[] readBuffer = new byte[1];
//            boolean read = false;
//            while(!read) {
//                try {
//                    String getInfo = "";
//                    Thread.sleep(100);
//                    while (bufferedInputStream.available() > 0) {
//                        int numBytes = bufferedInputStream.read(readBuffer);
//                        getInfo += new String(readBuffer);
//                        read = true;
//                    }
//                    feedback += getInfo;
//                    int length = getInfo.length();
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }


import configuration.Configurator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;
import network.NotifierHTTP;

public class RXCommunication implements SerialPortEventListener {
SerialPort serialPort;
    /** The port we're normally going to use. */
private static final String PORT_NAMES[] = {                  //"/dev/tty.usbserial-A9007UX1", // Mac OS X
        //"/dev/ttyUSB0", // Linux
        "COM12", // Windows
};
private BufferedReader input;
private OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;

public void initialize() {
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    if (portId == null) {
        System.out.println("Could not find COM port.");
        return;
    }

    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();

        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
    } catch (Exception e) {
        System.err.println(e.toString());
    }
}


public synchronized void close() {
    if (serialPort != null) {
        serialPort.removeEventListener();
        serialPort.close();
    }
}

public synchronized void serialEvent(SerialPortEvent oEvent) {
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
        try {
            String inputLine=null;
            if (input.ready()) {
                inputLine = input.readLine();
                            System.out.println(inputLine);
                            Configurator config = new Configurator();
    String args[]={"-p", "info", "-t","ARD1 - Mars", "-d", inputLine};
                            Interpreter interpreter = new Interpreter();
            NotifierHTTP notifier = new NotifierHTTP(config.getUrl());
            notifier.sendPOST(interpreter.buildJSON(args, config.getSettings()));
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    // Ignore all the other eventTypes, but you should consider the other ones.
}

public static void main(String[] args) throws Exception {
    RXCommunication main = new RXCommunication();
    main.initialize();
    Thread t=new Thread() {
        public void run() {
            //the following line will keep this app alive for 1000    seconds,
            //waiting for events to occur and responding to them    (printing incoming messages to console).
            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
        }
    };
    t.start();
    System.out.println("Started");
}
}