package com.example.testcm2.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.testcm2.R
import com.example.testcm2.dialog.ExpenseDialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExpenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense)

        val photo = findViewById<ImageView>(R.id.expense_image)
        val takePhoto =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
                if(bitmap == null){
                    photo.setImageResource(R.drawable.ic_photo)
                } else {
                    photo.setImageBitmap(bitmap)
                }
            }
        photo.setOnClickListener {
            takePhoto.launch(null)
        }

        findViewById<FloatingActionButton>(R.id.expense_add).setOnClickListener(){
            ExpenseDialogFragment(1).show(supportFragmentManager,null)
        }
        val toto = findViewById<View>(R.id.toto).setOnClickListener{
            if(checkPermission(Manifest.permission.CALL_PHONE)) {
                intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:0781745182"))
                startActivity(intent)
            }
        }

    }
    private fun checkPermission(permission: String): Boolean {
        var res = true
        if (ContextCompat.checkSelfPermission(applicationContext,permission) != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this,permission)) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
            }
            res = false
        }
        return res
    }
}