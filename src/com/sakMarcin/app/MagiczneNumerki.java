package com.sakMarcin.app;

import java.awt.EventQueue;

import com.sakMarcin.gui.MainFrame;

public class MagiczneNumerki
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
