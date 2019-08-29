package com.wallegameone;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Screens.GameScreen;
import Screens.MenuScreen;
import Screens.SkillTree;

public class IG extends Game
{

	public SpriteBatch batch;
	Texture img;

	@Override
	public void create ()
	{

		batch = new SpriteBatch();
		//THIS IS FOR TESTING PURPOSES (TESTING SKILL TREE) DATE: 8/15/19
		//this.setScreen(new MenuScreen(this));
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render ()
	{
		super.render();

	}

    @Override
	public void dispose () {

		batch.dispose();

	}
}
