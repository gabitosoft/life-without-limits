/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.and open the template in the editor.
 */

/**
 *
 * @author LWL
 */

import Arduino.Arduino;
import Arduino.MultiMessage;
import java.io.IOException;

import utils.Interpreter;
import network.NotifierHTTP;
import configuration.Configurator;
import utils.RXCommunication;


public class App {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {

            System.out.println("TempNotifier");
            
            RXCommunication main = new RXCommunication();
            main.initialize();
            System.out.println("Started");
            
            //Se crea un obteto llamado Arduino para instanciar la clase Arduino
            //De la librería Arduino para Java
//            Arduino Arduino = new Arduino();  
//            //Se instancia un objeto de la clase MultiMessage
//            //Se indica que se van a leer 3 sensores y que la clase Arduino fue instanciada
//            //mediante el obteto Arduino
//            MultiMessage multi = new MultiMessage(1, Arduino);
//            multi.getMessage(0);
            
            Configurator config = new Configurator();
            Interpreter interpreter = new Interpreter();
            NotifierHTTP notifier = new NotifierHTTP(config.getUrl());
            notifier.sendPOST(interpreter.buildJSON(args, config.getSettings()));
        } catch(IOException ex) {
            
            System.out.println(ex.getMessage());
            // TODO add to logger
        }
    }
}
