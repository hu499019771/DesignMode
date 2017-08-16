package com.chinabluedon.designmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.chinabluedon.designmodedemo.builder.Computer;
import com.chinabluedon.designmodedemo.builder.MacBuilder;
import com.chinabluedon.designmodedemo.proxy.DynamicProxy;
import com.chinabluedon.designmodedemo.proxy.ILawsuit;
import com.chinabluedon.designmodedemo.proxy.Lawyer;
import com.chinabluedon.designmodedemo.proxy.ProxySubject;
import com.chinabluedon.designmodedemo.proxy.RealSubject;
import com.chinabluedon.designmodedemo.proxy.XiaoMing;
import com.chinabluedon.designmodedemo.simple_factory.AudioCarFactory;
import com.chinabluedon.designmodedemo.simple_factory.AudioQ3;
import com.chinabluedon.designmodedemo.simple_factory.ContreteFactory;
import com.chinabluedon.designmodedemo.simple_factory.ContreteProductA;
import com.chinabluedon.designmodedemo.simple_factory.Product;
import com.chinabluedon.designmodedemo.uml.ImageActivity;
import com.chinabluedon.designmodedemo.wrapper.Boy;
import com.chinabluedon.designmodedemo.wrapper.Component;
import com.chinabluedon.designmodedemo.wrapper.ContreteComponent;
import com.chinabluedon.designmodedemo.wrapper.ContreteDecoratorA;
import com.chinabluedon.designmodedemo.wrapper.ExpensiveCloth;
import com.chinabluedon.designmodedemo.wrapper.Person;
import com.chinabluedon.designmodedemo.wrapper.PersonCloth;
import com.chinabluedon.designmodedemo.wrapper.PoorCloth;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                testSimleFactoryAudio();
            }
        });

    }

    private void testBuilder () {
        Computer computer = new MacBuilder()
                .board("苹果10主板")
                .display("三星显示器")
                .os("mac 12.0系统")
                .create();
        Toast.makeText(MainActivity.this, computer.toString(), Toast.LENGTH_SHORT).show();
    }

    private void gotoImageActivity () {
        startActivity(new Intent(MainActivity.this, ImageActivity.class));
    }

    private void testSimleFactoryAudio () {
        AudioQ3 audioCar = new AudioCarFactory().createAudioCar(AudioQ3.class);
        Toast.makeText(MainActivity.this, audioCar.drive(), Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, audioCar.selfNavigation(), Toast.LENGTH_SHORT).show();
    }

    private void testSimpleFactory () {
        Product product = ContreteFactory.createProduct(ContreteProductA.class);
        Toast.makeText(MainActivity.this, product.mothod(), Toast.LENGTH_SHORT).show();
    }

    private void testProxy1 () {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.visit();
    }

    private void testProxy2 () {
        Lawyer lawyer = new Lawyer(new XiaoMing());
        lawyer.submit();
    }

    private void testProxy3 () {
        ILawsuit xiaoMing = new XiaoMing();
        DynamicProxy dynamicProxy = new DynamicProxy(xiaoMing);
        ClassLoader classLoader = xiaoMing.getClass().getClassLoader();
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(classLoader, new Class[]{ILawsuit.class}, dynamicProxy);
        lawyer.submit();
    }

    private void testDecorator () {
        Component contreteComponent = new ContreteComponent();
        ContreteDecoratorA decoratorA = new ContreteDecoratorA(contreteComponent);
        decoratorA.operate();
    }

    private void testDecorator2 () {

        Person boy = new Boy();
        PersonCloth expensiveCloth = new ExpensiveCloth(boy);
        expensiveCloth.dress();
        PersonCloth poorCloth = new PoorCloth(boy);
        poorCloth.dress();
    }
}
