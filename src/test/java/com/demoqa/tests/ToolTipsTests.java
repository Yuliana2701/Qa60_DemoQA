package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase{


        @BeforeMethod
        public void precondition() {
            new HomePage(driver).getWidgets();
            new SidePanel(driver).selectToolTips().hideIFrames();
        }

        @Test
        public void toolTipsTest() {
            new ToolTipsPage(driver).hoverToToolTips()
                    .verifyToolTips("buttonToolTip");
        }
}
