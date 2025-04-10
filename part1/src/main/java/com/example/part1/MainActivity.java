package com.example.part1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextStudentId, editTextName, editTextMajor, editTextClass;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 显示ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("2411664 施翊聪");
        }


        editTextStudentId = findViewById(R.id.editTextStudentId);
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCollege = findViewById(R.id.spinnerCollege);
        editTextMajor = findViewById(R.id.editTextMajor);
        editTextClass = findViewById(R.id.editTextClass);

        /*借鉴AI 访问院系列表数据
        作用:是资源文件中读取一个字符串数组（colleges_array）。
        使用 ArrayAdapter 将这些字符串绑定到 Spinner。
        设置 Spinner 的下拉菜单和显示项的布局。
        最终使得 Spinner 能够显示一个学院名称的下拉列表。

        ArrayAdapter：这是一个适配器类，用于将数组数据绑定到 Spinner 或 ListView 组件中。可以使用资源文件中的数据或者直接使用数组
        createFromResource：用于从资源文件中创建 ArrayAdapter。它需要三个参数：
            this：当前活动的上下文（Context），用于访问应用的资源。
            R.array.colleges_array：资源文件中的数组 ID。这个数组应该定义在 res/values/arrays.xml 中，表示学院的名称列表。
            android.R.layout.simple_spinner_item：布局资源 ID，用于定义 Spinner 中每个项目的布局。simple_spinner_item 是 Android 框架提供的一个简单布局，它通常是一个单行 TextView
            setDropDownViewResource：设置 Spinner 下拉列表中每个项目的布局资源。simple_spinner_dropdown_item 是另外一个 Android 框架提供的布局，它通常具有一些额外的样式，比如更大的行间距，适合下拉菜单的显示。
        spinnerCollege.setAdapter(adapter);
              setAdapter：将适配器绑定到 Spinner。这一步将 ArrayAdapter 中的数据传递给 Spinner 以便显示。通过这个绑定，Spinner 会使用适配器提供的数据和布局来构建用户界面。
         */
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colleges_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(adapter);


        Button buttonExplicit = findViewById(R.id.buttonExplicit);
        Button buttonImplicit = findViewById(R.id.buttonImplicit);

        //显式跳转
        buttonExplicit.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            putExtras(intent);
            startActivity(intent);
        });

        //隐式跳转
        buttonImplicit.setOnClickListener(v -> {
            Intent intent = new Intent("com.example.part1.SECOND_ACTIVITY");
            putExtras(intent);
            startActivity(intent);
        });
    }

        //注册信息进行传递
    private void putExtras(Intent intent) {
        String studentId = editTextStudentId.getText().toString();
        String name = editTextName.getText().toString();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = (selectedGenderId == R.id.radioButtonMale) ? "男" : "女";
        String college = spinnerCollege.getSelectedItem().toString();
        String major = editTextMajor.getText().toString();
        String className = editTextClass.getText().toString();

        intent.putExtra("studentId", studentId);
        intent.putExtra("name", name);
        intent.putExtra("gender", gender);
        intent.putExtra("college", college);
        intent.putExtra("major", major);
        intent.putExtra("class", className);
    }
}
