package com.raynokriel.smartpantrymanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class AddEditIngredientActivity extends AppCompatActivity {
    //varaibles
    private DatabaseHelper dbHelper;
    private EditText editName;
    private EditText editQuantity;
    private Spinner spinnerUnit;
    private long itemId = -1;
    private Button deleteButton;

    //building the content and setting values if they exists for editing
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_ingredient);
        dbHelper = new DatabaseHelper(this);
        editName = findViewById(R.id.editIngredientName);
        editQuantity = findViewById(R.id.editIngredientQuantity);
        spinnerUnit =findViewById(R.id.spinnerUnit);

        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(v -> saveItem());

        deleteButton = findViewById(R.id.buttonDelete);
        deleteButton.setOnClickListener(v -> {
            dbHelper.deletePantryItem(itemId);
            Toast.makeText(this,R.string.item_deleted,Toast.LENGTH_SHORT).show();
            finish();
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.units_array, android.R.layout.simple_spinner_item);
        spinnerUnit.setAdapter(adapter);
        itemId = getIntent().getLongExtra(MainActivity.EXTRA_ITEM_ID,-1);

        if (itemId != -1) {
            setTitle(R.string.title_edit_ingredient);
            deleteButton.setVisibility(View.VISIBLE);
            loadExistingItem();
        } else {
            setTitle(R.string.title_add_ingredient);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadExistingItem() {
        PantryItem item = dbHelper.getPantryItem(itemId);
        if (item == null) {
            return;
        }
        editName.setText(item.getName());
        editQuantity.setText(String.valueOf(item.getQuantity()));
    }
    private void saveItem() {
        //read from input field in the app
        String name = editName.getText().toString().trim();
        String quantityText = editQuantity.getText().toString().trim();
    //error checks from the strings.xml to check inputs first
        if (TextUtils.isEmpty(name)) {
            editName.setError(getString(R.string.error_required));
            return;
        }
        if (TextUtils.isEmpty(quantityText)) {
            editQuantity.setError(getString(R.string.error_required));
            return;
        }
        double quantity;
        //through the correct error of not a number when converting QTY
        try {
            quantity =Double.parseDouble(quantityText);
        } catch (NumberFormatException e) {
            editQuantity.setError(getString(R.string.error_invalid_number));
            return;
        }
        //building the item to be saved
        PantryItem item = new PantryItem(0, name, quantity,
                spinnerUnit.getSelectedItem().toString(),"");

        //using the DB insert method from CRUD now
        if (itemId == -1) {
            dbHelper.addPantryItem(item);
            Toast.makeText(this,R.string.item_added,Toast.LENGTH_SHORT).show();
        } else {
            item.setId(itemId);
            dbHelper.updatePantryItem(item);
            Toast.makeText(this,R.string.item_updated,Toast.LENGTH_SHORT).show();
        }

        //showing the message of confirmation set in strings.xml as well
        Toast.makeText(this,R.string.item_added, Toast.LENGTH_SHORT).show();
        finish();
    }
}