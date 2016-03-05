package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	BitmapFont font;
	Texture img;
	Texture ladno;
    TextureAtlas atlas;
    Sprite sprite;
    Animation animation;
    float elapsedTime;
    float posX, posY;

	@Override
	public void create () {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
        ladno = new Texture("lada.png");
        font = new BitmapFont();
        atlas = new TextureAtlas("shit.pack");
        animation = new Animation(0.5f, atlas.getRegions());
        sprite = new Sprite(atlas.getRegions().first());

        posX = w/2 - sprite.getWidth()/2;
        posY = h/2 - sprite.getHeight()/2;

	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite.translateX(-1f);
            else
                sprite.translateX(-10.0f);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                sprite.translateX(1f);
            else
                sprite.translateX(10.0f);
        }
        batch.begin();
        sprite.draw(batch);
        batch.end();

//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();          sdfs
//        elapsedTime += Gdx.graphics.getDeltaTime();
//        batch.draw(animation.getKeyFrame(elapsedTime, true), 0, 0);
//        batch.end();
	}

    @Override
    public void dispose() {
        batch.dispose();
        atlas.dispose();
        super.dispose();

    }
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(button == Input.Buttons.LEFT){
            posX = screenX - sprite.getWidth()/2;
            posY = Gdx.graphics.getHeight() - screenY - sprite.getHeight()/2;
        }
        if(button == Input.Buttons.RIGHT){
            posX = Gdx.graphics.getWidth()/2 - sprite.getWidth()/2;
            posY = Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        float moveAmount = 1.0f;
        if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
            moveAmount = 10.0f;

        if(keycode == Input.Keys.LEFT)
            posX-=moveAmount;
        if(keycode == Input.Keys.RIGHT)
            posX+=moveAmount;
        return true;
    }
}
