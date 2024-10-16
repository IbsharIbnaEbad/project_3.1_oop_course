/*package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Delete_Stock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_stock);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}*/


package com.example.myapplication;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Delete_Stock extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText editTextName;
    private TextView textViewItemId;

    private TextView text_view_product_quantity;
    private TextView text_view_product_price;
    private ImageView imageViewProduct;
    private Button button_Delete;
    private Button button_Search;


    private DataBaseHelper databaseHelper;
    private byte[] bitmapToByteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_stock);

        editTextName = findViewById(R.id.text_view_product_name);
        textViewItemId = findViewById(R.id.text_view_product_id);
        text_view_product_quantity = findViewById(R.id.text_view_product_quantity);
        text_view_product_price = findViewById(R.id.text_view_product_price);
        imageViewProduct = findViewById(R.id.image_view_product);
        button_Search = findViewById(R.id.button_search);
        button_Delete = findViewById(R.id.button_delete);

        databaseHelper = new DataBaseHelper(this);

        button_Search.setOnClickListener(view -> searchProduct());
        button_Delete.setOnClickListener(view -> deleteProduct());
    }

    private void searchProduct() {
        String itemName = editTextName.getText().toString().trim();
        if (itemName.isEmpty()) {
            Toast.makeText(this, "Please enter a product name to search", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = databaseHelper.getProductByName(itemName);
        if (cursor != null && cursor.moveToFirst()) {
            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.COL_ID));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseHelper.COL_Item_PRICE));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseHelper.COL_Item_Description));
            byte[] image = cursor.getBlob(cursor.getColumnIndexOrThrow(DataBaseHelper.COL_Item_IMAGE_URI));

            text_view_product_quantity.setText(String.valueOf(text_view_product_quantity));
            text_view_product_price.setText(String.valueOf(text_view_product_price));
            textViewItemId.setText(" item ID: " + itemId);


            if (image != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                imageViewProduct.setImageBitmap(bitmap);
                bitmapToByteArray = image;
            }
            cursor.close();
        } else {
            Toast.makeText(this, "Product not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteProduct() {
        String itemName = editTextName.getText().toString().trim();

        databaseHelper.deleteProduct(itemName);
    }

}