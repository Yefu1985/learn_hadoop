/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.List;

import cousesummary.ReducerAsSummarizer;
import cousesummary.MapperAsReverter;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.MapDriver;
import org.apache.hadoop.mrunit.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

public class TestCourseSummary {

  private MapDriver<Text, Text, Text, Text> mapDriver;
  private ReduceDriver<Text, Text, Text, Text> reduceDriver;

  @Before
  public void setUp() {
    MapperAsReverter mapper = new MapperAsReverter();
    ReducerAsSummarizer reducer = new ReducerAsSummarizer();
    mapDriver = MapDriver.newMapDriver(mapper);;
    reduceDriver = ReduceDriver.newReduceDriver(reducer);
  }

  @Test
  public void testMapper() {
    mapDriver.withInput(new Text("studentA"), new Text("courseX"));
    mapDriver.withOutput(new Text("courseX"), new Text("studentA"));
    mapDriver.runTest();
  }

  @Test
  public void testReducer() {
    List<Text> values = new ArrayList<Text>();
    values.add(new Text("studentA"));
    values.add(new Text("studentB"));
    values.add(new Text("studentA"));
    reduceDriver.withInput(new Text("courseX"), values);
    reduceDriver.withOutput(new Text("courseX"),
        new Text("[studentA, studentB]"));
    reduceDriver.runTest();
  }
}
