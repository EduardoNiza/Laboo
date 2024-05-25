package EX2;

/* 
 * Durante o teste, o usuário não deve alterar manualmente a posição do cursor,
 * nem digitar ou pressionar qualquer tecla.
 * Para prevenir erros causados por ações manuais, o código inclui parâmetros
 * que verificam a posição do cursor antes de realizar qualquer ação relacionada a ele,
 * tentando neutralizar possíveis interferências.
 * Portanto, siga estas instruções para garantir a precisão dos resultados do teste. 
 * */


/**
 * FUI FAZER O EXERCICIO 4 E ACABEI QUEBRANDO O PROJETO, MAS ESTAVA TUDO FUNCIONANDO DO EXERCICIO 1, 2,3 E 5
 */

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import EX1.*;

public class TestaEX1
{
	private static Robot bot;
	private static View gui;

	@BeforeAll
	public static void createBot()
	{
		try
		{
			bot = new Robot();
		} catch (AWTException a)
		{
			System.err.println("Cannot create bot");
		}
		gui = new View();
	}

	@Test
	public void testNoInput()
	{
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getTextFieldLocation())))
		{
			bot.mouseMove((int) gui.getTextFieldLocation().getX(), (int) gui.getTextFieldLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
			System.err.println("Ooops!");
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		while (!(gui.isTextFieldEmpty()))
		{
			bot.keyPress(KeyEvent.VK_DELETE);
			try
			{
				Thread.sleep(400);
			} catch (InterruptedException ie)
			{
			}
			bot.keyRelease(KeyEvent.VK_DELETE);
		}
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getButtonLocation())))
		{
			bot.mouseMove((int) gui.getButtonLocation().getX(), (int) gui.getButtonLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		assertEquals("Write a number you wish to calculate", gui.getTextPrinted());
	}

	@Test
	public void testInputNegative()
	{
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getTextFieldLocation())))
		{
			bot.mouseMove((int) gui.getTextFieldLocation().getX(), (int) gui.getTextFieldLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		while (!(gui.isTextFieldEmpty()))
		{
			bot.keyPress(KeyEvent.VK_DELETE);
			try
			{
				Thread.sleep(400);
			} catch (InterruptedException ie)
			{
			}
			bot.keyRelease(KeyEvent.VK_DELETE);
		}
		bot.keyPress(KeyEvent.VK_SUBTRACT);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.keyRelease(KeyEvent.VK_SUBTRACT);
		bot.keyPress(KeyEvent.VK_1);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.keyRelease(KeyEvent.VK_1);
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getButtonLocation())))
		{
			bot.mouseMove((int) gui.getButtonLocation().getX(), (int) gui.getButtonLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		assertEquals("Only calculate a positive number", gui.getTextPrinted());
	}

	@Test
	public void testInputZero()
	{
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getTextFieldLocation())))
		{
			bot.mouseMove((int) gui.getTextFieldLocation().getX(), (int) gui.getTextFieldLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		while (!(gui.isTextFieldEmpty()))
		{
			bot.keyPress(KeyEvent.VK_DELETE);
			try
			{
				Thread.sleep(400);
			} catch (InterruptedException ie)
			{
			}
			bot.keyRelease(KeyEvent.VK_DELETE);
		}
		bot.keyPress(KeyEvent.VK_0);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.keyRelease(KeyEvent.VK_0);
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getButtonLocation())))
		{
			bot.mouseMove((int) gui.getButtonLocation().getX(), (int) gui.getButtonLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		assertEquals("Result: 1", gui.getTextPrinted());
	}

	@Test
	public void testInputPositive()
	{
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getTextFieldLocation())))
		{
			bot.mouseMove((int) gui.getTextFieldLocation().getX(), (int) gui.getTextFieldLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		while (!(gui.isTextFieldEmpty()))
		{
			bot.keyPress(KeyEvent.VK_DELETE);
			try
			{
				Thread.sleep(400);
			} catch (InterruptedException ie)
			{
			}
			bot.keyRelease(KeyEvent.VK_DELETE);
		}
		bot.keyPress(KeyEvent.VK_5);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.keyRelease(KeyEvent.VK_5);
		while (!(MouseInfo.getPointerInfo().getLocation().equals(gui.getButtonLocation())))
		{
			bot.mouseMove((int) gui.getButtonLocation().getX(), (int) gui.getButtonLocation().getY());
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException ie)
			{
			}
		}
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		try
		{
			Thread.sleep(400);
		} catch (InterruptedException ie)
		{
		}
		assertEquals("Result: 120", gui.getTextPrinted());
	}
}