/* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   Module Name          : com.senao.EncodeHandler
   Module Description   :

   Date Created      : 2017年10月31日
   Original Author   : 015336
   ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
package com.senao.handler;

import com.senao.Candidate;

/**
 * @author 015336
 */
public class EncodeHandler extends AbstractHandler {

	@Override
	public byte[] Perform(Candidate candidate, byte[] target) {
		byte[] result = target;
		if (target != null) {
			result = this.EncodeData(candidate, target);
		}
		return result;
	}

	private byte[] EncodeData(Candidate candidate, byte[] target) {
		return target;
	}
}
