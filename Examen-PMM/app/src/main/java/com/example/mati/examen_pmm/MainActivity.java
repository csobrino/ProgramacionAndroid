package com.example.mati.examen_pmm;
        import android.content.Intent;
        import android.os.Bundle;
//        import android.support.design.widget.TextInputLayout;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.RadioGroup;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_RESULTADOFACTURA = 0;
    private final static int REQUEST_AZAFATA = 1;

    private Spinner spinnerDestinos;
    private RadioGroup radioGroupTarifas;
    private CheckBox checkBoxCajaRegalo, checkBoxTarjetaDedicada, checkBoxGPS;
    private EditText editTextPesoPaquete;
    private TextView textViewCostetotal;
    private Button buttonCalculos, buttonPrecio;
 //   private TextInputLayout textInput;
    private Destino[] destinos = new Destino[]
            {
                    new Destino("Megane","Seat",20, R.drawable.megan1),
                    new Destino("x-11","Ferrari",100, R.drawable.ferrari1),
                    new Destino("Leon","Seat",30,R.drawable.leon1),
                    new Destino("Fiesta","Ford",40,R.drawable.fiesta2)

            };
    Factura factura = new Factura();
    ResultadoFactura RFactura = new ResultadoFactura();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponenteUI();
    }

    private void iniciarComponenteUI() {
        spinnerDestinos = (Spinner) findViewById(R.id.spinnerDestinos);
        radioGroupTarifas = (RadioGroup) findViewById(R.id.radioGroup_Tarifas);
        checkBoxCajaRegalo = (CheckBox) findViewById(R.id.checkBox_CajaRegalo);
        checkBoxTarjetaDedicada = (CheckBox) findViewById(R.id.checkBox_TarjetaDedicada);
        checkBoxGPS = (CheckBox) findViewById(R.id.checkBox_GPS);
        editTextPesoPaquete = (EditText) findViewById(R.id.editTextPesoPaquete);
        buttonCalculos = (Button) findViewById(R.id.buttonHacerCalculos);
        buttonPrecio = (Button) findViewById(R.id.buttonTotalPrecio);
        textViewCostetotal = (TextView) findViewById(R.id.textViewPreciototal);
      //  textInput = (TextInputLayout) findViewById(R.id.inputLayout_PesoPaquete);

        //IMPLEMENTACION DEL SPINNER
        AdaptadorSpinner adaptadorSpinner = new AdaptadorSpinner(this,destinos);
        spinnerDestinos.setAdapter(adaptadorSpinner);
        spinnerDestinos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                factura.setModelo(destinos[position].getModelo());
                factura.setMarca(destinos[position].getMarca());
                factura.setPrecioModelo(destinos[position].getPrecio())
                ;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //IMPLEMENTACION DE EL RADIOGROUP
        radioGroupTarifas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton_TarifaUrgente:
                        factura.setTipoSeguro("Con Seguro");
                        factura.setUrgente(true);
                        break;
                    case R.id.radioButton_TarifaNormal:
                        factura.setTipoSeguro("Sin Seguro");
                        factura.setUrgente(false);
                        break;
                }
            }
        });
        //IMPLEMENTACION DE LOS CHECKBOX
        checkBoxCajaRegalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtras().isEmpty()){
                    factura.setTipoExtras("Con Aire Acondicionado");
                }
                else{
                    factura.setTipoExtras("Con Aire acondicionado y Radio/DVD");
                }
            }
        });
        checkBoxTarjetaDedicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtras().isEmpty()){
                    factura.setTipoExtras("Con Radio/DVD");
                }
                else{
                    factura.setTipoExtras("Radio/DVD y Aire acondicionado");
                }

            }
        });
        checkBoxGPS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (factura.getTipoExtras().isEmpty()){
                    factura.setTipoExtras("GPS");
                }
                else{
                    factura.setTipoExtras("Radio/DVD y Aire acondicionado");
                }

            }
        });

        //IMPLEMENTACION DEL BOTON Y DEL EDIT TEXT
        buttonPrecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPesoPaquete.getText().toString().trim().isEmpty()){

                    editTextPesoPaquete.setError("Introduzca el tiempo de uso");
                }
                textViewCostetotal.setText(String.valueOf(factura.getPrecioFinal()));

            }
        });
        buttonCalculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextPesoPaquete.getText().toString().trim().isEmpty()){

                    editTextPesoPaquete.setError("Introduzca el tiempo de uso");

                }else{
                    if (factura.getTipoExtras().equals("")){
                        factura.setTipoExtras("Sin decoración");
                    }
                    factura.setPesoPaquete(Double.parseDouble(editTextPesoPaquete.getText().toString()));



                    Intent intent = new Intent(MainActivity.this,ResultadoFactura.class);
                    Bundle bundle = new Bundle();

                    bundle.putSerializable("factura",factura);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,REQUEST_RESULTADOFACTURA);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemMenu_AcercaDe:
                Dialogo_AcercaDe dialogoAcercaDe = new Dialogo_AcercaDe();
                dialogoAcercaDe.show(getSupportFragmentManager(),"Acerca de");
                return true;
            case R.id.itemMenu_Azafata:
                Intent intent = new Intent(MainActivity.this,DibujoAzafata.class);
                startActivityForResult(intent,REQUEST_AZAFATA);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        editTextPesoPaquete.setText("");
        checkBoxCajaRegalo.setChecked(false);
        checkBoxTarjetaDedicada.setChecked(false);
        checkBoxGPS.setChecked(false);
        spinnerDestinos.setSelection(0);
        radioGroupTarifas.check(R.id.radioButton_TarifaNormal);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_RESULTADOFACTURA:
                    Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                    break;
                case REQUEST_AZAFATA:
                    Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        else {
            Toast.makeText(this,"Operacion Cancelada",Toast.LENGTH_SHORT).show();
        }
    }
}
