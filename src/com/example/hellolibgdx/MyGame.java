package com.example.hellolibgdx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;

import android.os.Environment;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.XmlWriter;

public class MyGame implements ApplicationListener {
	@Override
	public void create() {
		StringWriter writer = new StringWriter();
		XmlWriter xml = new XmlWriter(writer);
		try {
			xml.element("persons")//���һ���ڵ�
					.attribute("size", "1")//�Լ�-ֵ�Ե���ʽָ���ýڵ������
					.element("person")//��persons�ڵ����������һ���ڵ�
					.attribute("name", "haungjundong")//��person�ڵ�ָ������ֵ
					.element("favourite words")//��person�ڵ��������һ��favourite words�Ľڵ�
					.text("XML is like violence. If it doesn't solve your problem, you're not using enough of it.")//ָ��favourite words�ڵ������
					.pop().pop().pop();
			
			File newxmlfile = new File(
					Environment.getExternalStorageDirectory()
							+ "/xmlparser_person_by_libGDX.xml");
			FileOutputStream fos = new FileOutputStream(newxmlfile);
			fos.write(writer.toString().getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(writer);
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����
	}
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
}
