package com.gb.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.gb.game.base.BaseScreen;
import com.gb.game.math.Rect;
import com.gb.game.sprite.Background;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;



    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        bg.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }
}
