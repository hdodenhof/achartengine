/**
 * Copyright (C) 2013 Henning Dodenhof
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.achartengine.chart;

import java.util.List;

import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/**
 * The overlay chart rendering class.
 */
public class OverlayChart extends XYChart {
  /** The constant to identify this chart type. */
  public static final String TYPE = "Overlay";

  OverlayChart() {
  }

  /**
   * Builds a new overlay chart instance.
   * 
   * @param dataset the multiple series dataset
   * @param renderer the multiple series renderer
   */
  public OverlayChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
    super(dataset, renderer);
  }

  /**
   * The graphical representation of a series.
   * 
   * @param canvas the canvas to paint to
   * @param paint the paint to be used for drawing
   * @param points the array of points to be used for drawing the series
   * @param seriesRenderer the series renderer
   * @param yAxisValue the minimum value of the y axis
   * @param seriesIndex the index of the series currently being drawn
   * @param startIndex the start index of the rendering points
   */
  @Override
  public void drawSeries(Canvas canvas, Paint paint, List<Float> points,
      SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {

    paint.setColor(seriesRenderer.getColor());
    paint.setStyle(Style.FILL);

    canvas.drawRect(0, 0, points.get(0), canvas.getHeight(), paint);
    canvas.drawRect(points.get(2), 0, canvas.getWidth(), canvas.getHeight(), paint);
  }

  @Override
  protected ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values,
      float yAxisValue, int seriesIndex, int startIndex) {

    return new ClickableArea[] {};
  }

  /**
   * Returns if the chart should display the null values.
   * 
   * @return if null values should be rendered
   */
  @Override
  protected boolean isRenderNullValues() {
    return true;
  }

  /**
   * Returns the default axis minimum.
   * 
   * @return the default axis minimum
   */
  @Override
  public double getDefaultMinimum() {
    return 0;
  }

  /**
   * Returns the chart type identifier.
   * 
   * @return the chart type
   */
  @Override
  public String getChartType() {
    return TYPE;
  }

  @Override
  public int getLegendShapeWidth(int seriesIndex) {
    return 0;
  }

  @Override
  public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y,
      int seriesIndex, Paint paint) {
  }
}
