/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.service.Handler
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.handler;

import com.senao.Candidate;

/**
 * @author 015336
 */
public interface Handler {
	public byte[] Perform(Candidate candidate, byte[] target);
}
