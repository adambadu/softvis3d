import * as React from "react";
import {shallow} from "enzyme";
import {expect} from "chai";
import MetricKey from "../../../../src/components/scene/information/MetricKey";
import Metric from "../../../../src/classes/Metric";
import {TreeElement} from "../../../../src/services/sonarqube/SoftVis3dTree";

describe("<MetricKey/>", () => {

    it("should show title and metric", () => {
        let title: string = "ExpectedTitle";
        let expectedMetricName: string = "ExpectedMetricName";

        let expectedMetric: Metric = new Metric("123", expectedMetricName, "");

        const bottomBarMetricInfo = shallow(
            <MetricKey title={title} metric={expectedMetric} selectedElement={null}/>
        );

        expect(bottomBarMetricInfo.html()).to.include(expectedMetricName);
        expect(bottomBarMetricInfo.html()).to.include(title);
    });

    it("should show title, metric and measure", () => {
        let title: string = "ExpectedTitle";
        let expectedMetricName: string = "ExpectedMetricName";

        let expectedMetric: Metric = new Metric("123", expectedMetricName, "");

        let expectedMeasure: number = 55;
        let selectedElement: TreeElement = new TreeElement("", "", {
            123: expectedMeasure
        }, "", "", "FIL");
        const bottomBarMetricInfo = shallow(
            <MetricKey title={title} metric={expectedMetric} selectedElement={selectedElement}/>
        );

        expect(bottomBarMetricInfo.html()).to.include(expectedMetricName);
        expect(bottomBarMetricInfo.html()).to.include(title);
        expect(bottomBarMetricInfo.html()).to.include(expectedMeasure);
    });

});