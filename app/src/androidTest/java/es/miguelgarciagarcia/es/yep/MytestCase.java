package es.miguelgarciagarcia.es.yep;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Vaio on 07/03/2016.
 */
public class MytestCase extends ActivityInstrumentationTestCase2<LoginActivity> {

    private Button login;
    private EditText username;
    private EditText password;
    private static final String Login = "prueba";
    private static final String Password = "prueba";
    private LoginActivity actividad;
    public MytestCase() {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

// Obtengo la activity actual
        actividad = getActivity();

// Instancio lo necesario (edittext y button)
        username = (EditText) actividad.findViewById(R.id.usernameField);
        password = (EditText) actividad.findViewById(R.id.passwordField);
        login = (Button)actividad.findViewById(R.id.LoginButton);

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }


    public void testAddValues() {

        boolean UsuarioLogeado=false;
        TouchUtils.tapView(this, username);
        getInstrumentation().sendStringSync(Login);

// Meto prueba en el Password
        TouchUtils.tapView(this, password);
        getInstrumentation().sendStringSync(Password);

// Clikeo el boton de LogIn
        TouchUtils.clickView(this, login);

        assertTrue("Login result expect to be sucesfull and has been...", UsuarioLogeado);

    }

}
