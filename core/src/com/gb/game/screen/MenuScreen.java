package com.gb.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.gb.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 v;
    private Texture ship;
    private Vector2 position;
    private Vector2 touch;
    private Vector2 speed;
    private Vector2 temp;


    @Override
    public void show() {
        super.show();
        img = new Texture("background_space.png");
        ship = new Texture("ship.png");
        position = new Vector2(1, 1);
        touch = new Vector2();
        speed = new Vector2();
        temp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0, 0, 0, 0);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(ship, position.x, position.y, 128, 128);
        batch.end();
        temp.set(touch);
        if(temp.sub(position).len() <= speed.len()){
            position.set(touch);
            speed.setZero();
        }
        else {
            position.add(speed);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        batch.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        speed.set(touch.cpy().sub(position).setLength(1.0f));
        return false;
    }
}
