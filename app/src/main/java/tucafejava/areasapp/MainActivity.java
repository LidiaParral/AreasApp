/**
 * Tu Cafe Java
 * @author Ing. Dick Díaz Delgado
 * https://tucafejava.blogspot.com/
 * Ejercicio 05
 **/
package tucafejava.areasapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edRadio;
    EditText edAlturaT;
    EditText edBaseT;
    EditText edAlturaR;
    EditText edBaseR;

    Button bCirculo;
    Button bTriangulo;
    Button bRectangulo;

    TextView ttReCirculo;
    TextView ttReTriangulo;
    TextView ttReRectangulo;

    AlertDialog.Builder dialog;
    double area;
    DecimalFormat formato = new DecimalFormat("#.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edRadio = (EditText) findViewById(R.id.eRadio);
        edAlturaT = (EditText) findViewById(R.id.eAlturaT);
        edBaseT = (EditText) findViewById(R.id.eBaseT);
        edAlturaR = (EditText) findViewById(R.id.eAlturaR);
        edBaseR = (EditText) findViewById(R.id.eBaseR);

        bCirculo = (Button) findViewById(R.id.bCalcularCirculo);
        bTriangulo = (Button) findViewById(R.id.bCalcularTriangulo);
        bRectangulo = (Button) findViewById(R.id.bCalcularRectangulo);

        ttReCirculo = (TextView) findViewById(R.id.tresultado_circulo);
        ttReTriangulo = (TextView) findViewById(R.id.tresultado_triangulo);
        ttReRectangulo = (TextView) findViewById(R.id.tresultado_rectangulo);

        bCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bCirculo.getText().toString().equals("Limpiar")){
                    edRadio.setText("");
                    ttReCirculo.setText("");
                    edRadio.requestFocus();
                    bCirculo.setText("Calcular");
                }else{
                    if(edRadio.getText().toString().length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el radio del círculo");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                edRadio.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        area = Math.pow(Double.parseDouble(edRadio.getText().toString()), 2.0) * Math.PI;
                        ttReCirculo.setText("El área es: " + formato.format(area));
                        bCirculo.setText("Limpiar");
                    }
                }
            }
        });

        bTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bTriangulo.getText().toString().equals("Limpiar")){
                    edAlturaT.setText("");
                    edBaseT.setText("");
                    ttReTriangulo.setText("");
                    edBaseT.requestFocus();
                    bTriangulo.setText("Calcular");
                }else{
                    if(edAlturaT.getText().toString().length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar la altura del triángulo");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                edAlturaT.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        if(edBaseT.getText().toString().length() == 0){
                            dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("Error");
                            dialog.setMessage("Ingresar la base del triángulo");
                            dialog.setCancelable(false);
                            dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo, int id) {
                                    dialogo.cancel();
                                    edBaseT.requestFocus();
                                }
                            });
                            dialog.show();
                        }else{
                            area = Double.parseDouble(edAlturaT.getText().toString()) * Double.parseDouble(edBaseT.getText().toString()) / 2;
                            ttReTriangulo.setText("El área es: " + formato.format(area));
                            bTriangulo.setText("Limpiar");
                        }
                    }
                }
            }
        });

        bRectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bRectangulo.getText().toString().equals("Limpiar")){
                    edAlturaR.setText("");
                    edBaseR.setText("");
                    ttReRectangulo.setText("");
                    edBaseR.requestFocus();
                    bRectangulo.setText("Calcular");
                }else{
                    if(edAlturaR.getText().toString().length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar la altura del rectángulo");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                edAlturaR.requestFocus();
                            }
                        });
                        dialog.show();
                    }else{
                        if(edBaseR.getText().toString().length() == 0){
                            dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("Error");
                            dialog.setMessage("Ingresar la base del rectángulo");
                            dialog.setCancelable(false);
                            dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogo, int id) {
                                    dialogo.cancel();
                                    edBaseR.requestFocus();
                                }
                            });
                            dialog.show();
                        }else{
                            area = Double.parseDouble(edAlturaR.getText().toString()) * Double.parseDouble(edBaseR.getText().toString());
                            ttReRectangulo.setText("El área es: " + formato.format(area));
                            bRectangulo.setText("Limpiar");
                        }
                    }
                }
            }
        });
    }
}
