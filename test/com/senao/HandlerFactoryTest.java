/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.HandlerFactoryTest
   Module Description   :

   Date Created      : 2017年11月8日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao;

import org.junit.Test;

import com.senao.factory.HandlerFactory;

/**
 * @author 015336
 */
public class HandlerFactoryTest
{
	@Test
	public void main()
	{
		HandlerFactory handlerFactory = new HandlerFactory();
		try
		{
			handlerFactory.Create("");
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
