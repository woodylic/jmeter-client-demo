package com.github.woodylic.jmeter.client;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * Created by choli on 2017/1/20.
 */
public class PerformanceTest extends AbstractJavaSamplerClient {

	@Override
	public Arguments getDefaultParameters() {
		Arguments arguments = new Arguments();
		arguments.addArgument("name", "John");

		return arguments;
	}

	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
		String name = javaSamplerContext.getParameter("name");

		SampleResult sampleResult = new SampleResult();
		sampleResult.setSampleLabel("My Test Label");
		try {
			sampleResult.sampleStart();	//jmeter开始统计响应时间

			ClassToBeTested sut = new ClassToBeTested();
			String testResult = sut.sayHello(name);

			sampleResult.setResponseData(testResult);
			sampleResult.setDataType(SampleResult.TEXT);
			sampleResult.setSuccessful(true);
		}
		catch (Throwable e){
			sampleResult.setSuccessful(false);
			e.printStackTrace();
		}
		finally {
			sampleResult.sampleEnd();
		}

		return sampleResult;
	}
}
