/**
  @file sensor_temperatura
  @brief Ejemplo de uso del modulo de temperatura y humedad compatible para las placas arduino
  
  Con este modulo podremos leer la  temperatura y humedad actual correspondiente al modulo dht11. Este dispositivo cuenta con tres pines:
  
  VCC  -> (+)
  DATA -> (pin digital) 
  GND  -> (-)

  @author SCESI
  @date 04/2014

*/

#include <DHT.h>  

/**
  @brief Libreria para establecer la configuracion del modulo
  @param Establece el pin digital que recibira los datos
  @param Nombre del modelo que se esta conectando DHT11
  
  @returns Objeto para el manejo del modulo
  
  */
DHT dht(2, DHT11); 

void setup()
{  
  Serial.begin(9600); 
  Serial.println(" -- iniciando dispositivo de temperatura y humedad DHT11");
  dht.begin();
}

void loop()
{
  // leer huemdad
  //float h = dht.readHumidity();
  
  // leer temperatura
  float t = dht.readTemperature();

  //  comprueba su los valores no son nulos
  if(isnan(t)) 
  {  
    Serial.println(" -- !! No data received");
  } else 
  {
    // Muestra el valor de humedad
    //Serial.print("Venus1 - humedad: ");     Serial.print(h); Serial.print(" %\t");
    Serial.print("Venus1 - temperatura: "); Serial.print(t); Serial.print(" *C\n");
  }
  
  delay(500);
}
