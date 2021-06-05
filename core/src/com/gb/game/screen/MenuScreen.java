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
    private Vector2 temp;
    private float shipSpeed = 10.4f;


    @Override
    public void show() {
        super.show();
        ship = new Texture("Redsquare.png");
        position = new Vector2(1, 1);
        touch = new Vector2();
        v = new Vector2();
        temp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        ScreenUtils.clear(0.4f, 0, 0.91f, 0);
        batch.begin();
        batch.draw(ship, position.x, position.y, 1f, 1f);
        batch.end();
        temp.set(touch);
        if(temp.sub(position).len() <= v.len()){
            position.set(touch);
            v.setZero();
        }
        else {
            position.add(v);
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
        v.set(touch.cpy().sub(position).setLength(shipSpeed));
        return false;
    }
}
